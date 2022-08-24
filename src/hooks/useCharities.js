import {useMemo} from "react";

export const useCharities = (charities, sort, query) => {

    return useMemo(() => {
        return charities.filter(charity => charity.title.toLowerCase().includes(query))
    }, [query, charities]);
}