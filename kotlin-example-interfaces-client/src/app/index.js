/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */
import React from 'react';
import ReactDOM from 'react-dom';

import MyFirstComponent from './components/MyFirstComponent';

function render() {
    ReactDOM.render(
        <MyFirstComponent />,
        document.getElementById('react-root')
    );
}

render();

if (module.hot) {
    module.hot.accept(() => true, render);
}