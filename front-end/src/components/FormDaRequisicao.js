import React, { useState } from "react";
import Usuario from "./Usuario";

class ObjetoRequest {
    constructor(id, name, email, phone, password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}

let status = 0;

const FormDaRequisicao = () => {
    const [valor, setValor] = useState(0);
    const [obj, setObj] = useState(new ObjetoRequest());

    const handleChange = (event) => {
        setValor(event.target.value);
    }

    const requisicaoHttpGet = async () => {
        let url = `http://localhost:8080/user/${valor}`;
        await fetch(url, {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "GET",
        }).then((res) => {
            status = res.status;
            return res.json()
        }).then(user => {
            setObj(new ObjetoRequest(user.id, user.name, user.email, user.phone, user.password))
        }).catch((res) => console.log(res));
        // fetch(url)
        // .then(res => res.json())
        // .then(user => console.log(user))
        // .catch(err => console.log(err))
    }

    const verificacaoRequisicao = () => {
        if (status === 200) {
            return (
                <Usuario id={obj.id} name={obj.name} email={obj.email} phone={obj.phone} password={obj.password} />
            )
        } else if (status === 500) {
            return (<p>Usuário não encontrado. ID pesquisado: {valor}</p>)
        }
    }

    return (
        <div>
            <p>Id do User: </p>
            <input type='number' className="inputID" placeholder='Digite aqui o ID' value={valor} onChange={handleChange}></input>
            <button onClick={requisicaoHttpGet}>Pesquisar</button>

            {(status === 0) ? <p> </p> : <p>Status Requisição: {status}</p>}
            {verificacaoRequisicao()}
        </div>
    )
}

export default FormDaRequisicao;