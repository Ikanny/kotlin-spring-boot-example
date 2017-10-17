/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import { GET_CURRENT_TIME } from './types';

export default function(state = {}, action) {
    switch (action.type) {
        case GET_CURRENT_TIME:
            return Object.assign({}, state, {
                currentTime: action.currentTime
            });

        default:
            return {};
    }
}