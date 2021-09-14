import React from "react";
import SectorService from "../src/service/sector-service"
import FormService from "../src/service/form-service"
import Form from "react-validation/build/form";
import Sector from "./component/Sector";

export default class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: '',
            id: null,
            username: '',
            sectorId: null,
            agreeToTerm: false,
            sectors: []
        }
    }

    componentDidMount() {
        SectorService.getSectors()
            .then(resp => {
                let data = resp.data
                this.setState({
                    sectors: data
                })
            })
            .catch(err => {
                this.setState({error: err.response.data});
            })
    }

    onHandleChange = (event) => {
        const {name, value} = event.target;
        this.setState({
            [name]: value
        });
    }

    onClickHandle = () => {
        let isPublic = !this.state.agreeToTerm;
        this.setState({
            agreeToTerm: isPublic
        });
    }

    saveForm = (e) => {
        e.preventDefault()
        FormService.saveForm(
            this.state.username,
            this.state.sectorId,
            this.state.agreeToTerm)
            .then(resp => {
                let data = resp.data
                this.setState({
                    error: '',
                    id: data.id,
                    username: data.username,
                    sectorId: data.sectorId,
                    agreeToTerm: data.agreeToTerm
                })
            })
            .catch(err => {
                this.setState({error: err.response.data});
            })
    }

    updateForm = (e) => {
        e.preventDefault()
        FormService.updateForm(
            this.state.id,
            this.state.username,
            this.state.sectorId,
            this.state.agreeToTerm)
            .then(resp => {
                let data = resp.data
                this.setState({
                    error: '',
                    id: data.id,
                    username: data.username,
                    sectorId: data.sectorId,
                    agreeToTerm: data.agreeToTerm
                })
            })
            .catch(err => {
                this.setState({error: err.response.data});
            })
    }

    getSectors = () => {
        return (
            <>
                <Sector sectors={this.state.sectors}/>
            </>
        )
    }

    applyAppropriateAction = () => {
        return this.state.id == null
            ? this.saveForm
            : this.updateForm
    }

    render() {
        return (
            <div>
                {this.state.error &&
                <h1 style={{color: 'red'}}>{this.state.error}</h1>}
                <Form onSubmit={this.applyAppropriateAction()}>
                    <div>
                        Please enter your name and pick the Sectors you are currently involved in.
                    </div>
                    <br/>

                    Name:
                    <input type="text"
                           name="username"
                           onChange={this.onHandleChange}
                           value={this.state.username}
                    />
                    <br/>
                    Selectors:
                    <select multiple=""
                            size="5"
                            name="sectorId"
                            onChange={this.onHandleChange}
                            value={this.state.sectorId}>

                        {this.getSectors()}
                    </select>
                    <br/>
                    <input type="checkbox"
                           name="agreeToTerm"
                           onChange={this.onClickHandle}
                           value={this.state.agreeToTerm}
                    />
                    Agree to terms
                    <br/>
                    <input type="submit" value="Save"/>
                </Form>
            </div>
        )
    }
}