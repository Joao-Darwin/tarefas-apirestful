import React from 'react'

const fetchTask = async (idTask) => {
    const APIresponse = await fetch('http://localhost:8080/task/1');
    const data = APIresponse.json();
    return data;
} 

const TaskRequest = () => {
    let task = fetchTask(1);
    return (
        <div>
            <p>{task}</p>
        </div>
    )
    
}

export default TaskRequest;