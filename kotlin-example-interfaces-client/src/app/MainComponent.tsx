/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import * as React from 'react';
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';
import {Provider} from 'react-redux';
import {Store} from "redux";
import {StoreState} from "./type";

// child components
import { Header } from './components/Header';

import { CurrentTimeComponent } from './modules/currenttime';
import { MyRecordComponent } from './modules/myrecord';

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
                    <Header title={"example application"} />
                    <Router>
                        <div>
                            <ul>
                                <li><Link to="/current-time">current time</Link></li>
                                <li><Link to="/my-record">my record</Link></li>
                            </ul>

                            <hr/>
                            <Route path="/current-time" component={CurrentTimeComponent}/>
                            <Route path="/my-record" component={MyRecordComponent} />
                        </div>
                    </Router>
                </div>
            </Provider>
        );
    }
}