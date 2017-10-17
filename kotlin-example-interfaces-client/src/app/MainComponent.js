/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import React from 'react';
import PropTypes from 'prop-types';
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';
import {Provider} from 'react-redux';
import MyFirstComponent from './components/MyFirstComponent';
import CurrentTimeComponent from './modules/currenttime/CurrentTimeComponent';

const MainComponent = ({ store }) => (
    <Provider store={store}>
        <Router>
            <div>
                <ul>
                    <li><Link to="/test">test</Link></li>
                    <li><Link to="/current-time">current time</Link></li>
                </ul>

                <hr/>

                <Route path="/test" component={MyFirstComponent} />
                <Route path="/current-time" component={CurrentTimeComponent} />
            </div>
        </Router>
    </Provider>
);

MainComponent.propTypes = {
    store: PropTypes.object.isRequired
};

export default MainComponent;