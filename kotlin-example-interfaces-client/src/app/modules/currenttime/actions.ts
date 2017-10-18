/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import * as fetch from 'isomorphic-fetch';

import { GET_CURRENT_TIME } from './types';

export function getCurrentTime() {
    return dispatch =>
        fetch('/api/current-time')
            .then(response => response.json())
            .then(json => dispatch({
                type: GET_CURRENT_TIME,
                currentTime: json.currentTime
            }));
}