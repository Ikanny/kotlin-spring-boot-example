/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import { GET_CURRENT_TIME } from './types';

export default function(state = {}, action) {
    switch (action.type) {
        case GET_CURRENT_TIME:
            console.log('in reducer current time :', action);
            return Object.assign({}, state, {
                currentTimeModule: {
                    currentTIme: action.currentTime
                }
            });
        default:
            return {};
    }
}