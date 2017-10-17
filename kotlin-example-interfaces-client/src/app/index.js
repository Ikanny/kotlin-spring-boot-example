/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */
import React from 'react';
import ReactDOM from 'react-dom';
import createStore from './store';

import MainComponent from './MainComponent';

function render() {
    ReactDOM.render(
        <MainComponent store={createStore({})}/>,
        document.getElementById('react-root')
    );
}

render();

if (module.hot) {
    module.hot.accept(() => true, render);
}