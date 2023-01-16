import './App.css';
import SearchBar from './components/SearchBar';
import TaskRequest from './components/TaskRequest';

function App() {
  return (
    <div className="App">
      <h1>Tarefas</h1>
      <SearchBar />
      <TaskRequest />
    </div>
  );
}

export default App;
