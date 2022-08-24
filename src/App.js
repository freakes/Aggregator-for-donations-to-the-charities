import './styles/App.css';
import CharityService from "./API/CharityService";
import Navbar from "./components/UI/navbar/Navbar";
import 'bootstrap/dist/css/bootstrap.min.css';
import {useEffect, useState} from "react";
import {useFetching} from "./hooks/useFetching";
import CharityList from "./components/CharityList";
import {useCharities} from "./hooks/useCharities";

function App() {
    const [charities, setCharities] = useState([]);
    const [filter, setFilter] = useState({sort: '', query: ''});
    const searchedCharities = useCharities(charities, filter.sort, filter.query)


    const [fetchCharities, isCharitiesLoading, charityError] = useFetching(async () => {
        const response = await CharityService.getAll();
        setCharities(response.data);
        console.log(charities);
    });

    useEffect(() => {
        fetchCharities();
    }, [])


  return (
    <div className="App">
        <Navbar
            filter={filter}
            setFilter={setFilter}
        />
        {charityError &&
            <h1>Произошла ошибка ${charityError}</h1>
        }
        {isCharitiesLoading
            ? <h1 style={{textAlign: 'center'}}>Идёт загрузка...</h1>
            : <CharityList
                charityList={searchedCharities}
            />
        }
    </div>

  );
}

export default App;
