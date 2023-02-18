import React from "react"

const Usuario = ({id, name, email, phone, password}) => {
    return (
        <div>
            <p>Id: {id}</p>
            <p>Nome: {name}</p>
            <p>Email: {email}</p>
            <p>Telefone: {phone}</p>
            <p>Senha: {password}</p>
        </div>
    )
}

export default Usuario;