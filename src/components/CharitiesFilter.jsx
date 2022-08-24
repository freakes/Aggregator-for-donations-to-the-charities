import React from 'react';
import MyInput from "./UI/input/MyInput";

const CharitiesFilter = ({filter, setFilter}) => {
    return (
        <div>
            <MyInput
                value={filter.query}
                placeholder="Поиск..."
                onChange={e => setFilter({...filter, query: e.target.value})}
            />
        </div>
    );
};

export default CharitiesFilter;