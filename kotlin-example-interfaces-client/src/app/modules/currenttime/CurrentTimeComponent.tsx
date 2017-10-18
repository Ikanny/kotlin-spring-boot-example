/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import * as React from 'react';
import { connect } from 'react-redux';
import { getCurrentTime } from './actions';

const styles = require('./CurrentTimeComponent.css');

export type StateType = {
    currentTime: number;
}

export type ActionType = {
    fetchCurrentTime: any
}

export type PropsType = StateType & ActionType;

export class CurrentTimeComponent extends React.Component<PropsType> {

    props: PropsType;

    componentDidMount() {
        const { fetchCurrentTime, currentTime } = this.props;
        if (!currentTime) {
            fetchCurrentTime();
        }
    }

    render() {
        return (
            <div>
                <h2 className={styles.main_title}>{this.props.currentTime}</h2>
            </div>
        );
    }
}

function mapStateToMap(state: any) {
    const currentTimeModule = state.currentTimeModule || {};
    return {
        currentTime: currentTimeModule.currentTime
    };
}

function mapDispatchToProps(dispatch: any) {
    return {

    };
}

// export const CurrentTimeComponent = connect(mapStateToMap)(_CurrentTimeComponent);