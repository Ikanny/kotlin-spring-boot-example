/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */
import * as React from 'react';
import * as ReactDOM from 'react-dom';

import { configureStore } from './store';
import { MainComponent } from './MainComponent';

function render() {
    ReactDOM.render(
        <MainComponent store={configureStore({})}/>,
        document.getElementById('react-root')
    );
}

render();

if (module['hot']) {
    module['hot'].accept(() => true, render);
}