/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import * as React from 'react';
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';
import {Provider} from 'react-redux';
import { CurrentTimeComponent } from './modules/currenttime/container';
import {Store} from "redux";
import {StoreState} from "./type";

// child components
import { Header } from './components/Header';

type PropTypes = {
    store: Store<StoreState>
}

export class MainComponent extends React.Component<PropTypes> {

    props: PropTypes;

    render() {
        const store = this.props.store;

        return (
            <Provider store={store}>
                <div>
                    <Header title={"example aplication"} />
                    <Router>
                        <div>
                            <ul>
                                <li><Link to="/current-time">current time</Link></li>
                            </ul>

                            <hr/>
                            <Route path="/current-time" component={CurrentTimeComponent}/>
                        </div>
                    </Router>
                </div>
            </Provider>
        );
    }
}