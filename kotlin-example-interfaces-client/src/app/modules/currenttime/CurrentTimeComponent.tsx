/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import * as React from 'react';
import { connect } from 'react-redux';
import { getCurrentTime } from './actions';

import * as styles from './CurrentTimeComponent.css';
// const styles = require('./CurrentTimeComponent.css');

type PropTypes = {
    dispatch: any,
    currentTime: number
};

class _CurrentTimeComponent extends React.Component<PropTypes> {

    props: PropTypes;

    componentDidMount() {
        const { dispatch, currentTime } = this.props;
        if (!currentTime) {
            dispatch(getCurrentTime());
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

export const CurrentTimeComponent = connect(mapStateToMap)(_CurrentTimeComponent);