/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import { combineReducers } from 'redux';
import currentTimeReducers from './modules/currenttime/reducers';

export default combineReducers({
    currentTime: currentTimeReducers
});