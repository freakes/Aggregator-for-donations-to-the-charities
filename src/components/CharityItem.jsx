import React from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const CharityItem = (props) => {
    return (
        <Card className="col-md-2" style={{marginTop: "10px", marginLeft: "38px", height: "auto"}} >
            <Card.Img variant="top" src={props.picture} alt={props.id} />
            <Card.Body>
                <Card.Text>
                    {props.title}
                </Card.Text>
                <div className="charity_item_button">
                <a href={props.link}><Button variant="primary">Открыть страницу</Button></a>
                </div>
            </Card.Body>
        </Card>
    );
};





export default CharityItem;