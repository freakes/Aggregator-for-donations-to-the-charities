import React from 'react';
import CharityItem from "./CharityItem";
import {Container, Row} from "react-bootstrap";

const CharityList = ({charityList}) => {
    if (!charityList.length) {
        return (
            <h1 style={{textAlign: 'center'}}>Организации не найдены!</h1>
        )
    }

    return (
        <div className="charity__list">
            <Container>
                <Row>
            {charityList.map((charity) => (
                    <CharityItem
                        key={charity.id}
                        id={charity.id}
                        title={charity.title}
                        link={charity.link}
                        picture={charity.picture}
                    />
            ))}
                </Row>
            </Container>
        </div>
    );
};

export default CharityList;