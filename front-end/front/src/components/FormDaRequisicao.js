import React, { useState } from "react";

const FormDaRequisicao = () => {
    const [valor, setValor] = useState('');

    const handleChange = (event) => {
        setValor(event.target.value);
    }

    const requisicaoHttp = () => {
        let url = `http://localhost:8080/user/${valor}`;
        fetch(url, {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "GET",
        }).then((res) => {
            console.log(res.json());
        }).catch((res) => console.log(res));
    }

    return (
        <div>
            <p>Id do User: </p>
            <input type='number' className="inputID" placeholder='Digite aqui o ID' value={valor} onChange={handleChange}></input>
            <button onClick={requisicaoHttp}>Pesquisar</button>
            <p>{valor}</p>
        </div>
    )
}

export default FormDaRequisicao;