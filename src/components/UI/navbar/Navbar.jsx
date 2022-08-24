import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import CharitiesFilter from "../../CharitiesFilter";

const Navbar = ({filter, setFilter}) => {
    return (
        <header>
            <Container>
                <Row className="navbar">
                    <Col md={6} className="header__title">
                        Список благотворительных организаций Ростовской области
                    </Col>
                    <Col md={{span: 3, offset: 3}}>
                        <CharitiesFilter
                            filter={filter}
                            setFilter={setFilter}
                        />
                    </Col>
                </Row>
            </Container>
        </header>
            );
};

export default Navbar;