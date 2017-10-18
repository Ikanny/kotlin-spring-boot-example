/**
 * @author ryuikhan
 * @since 2017. 10. 18.
 */
import { connect } from 'react-redux';
import { CurrentTimeComponent as Component, StateType, ActionType } from './CurrentTimeComponent';
import { getCurrentTime } from './actions';

function mapStateToProps(state, currentProps): StateType {
    const currentTimeModule = state.currentTimeModule || {};
    return {
        currentTime: currentTimeModule.currentTime
    };
}

function mapDispatchToProps(dispatch, currentProps): ActionType {
    return {
        fetchCurrentTime: () => dispatch(getCurrentTime())
    };
}

export const CurrentTimeComponent = connect(mapStateToProps, mapDispatchToProps)(Component);
