/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import React from 'react';
import { connect } from 'react-redux';
import { getCurrentTime } from './actions';

import styles from './CurrentTimeComponent.css';

class CurrentTimeComponent extends React.Component {

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

function mapStateToMap(state) {
    const currentTimeModule = state.currentTimeModule || {};
    return {
        currentTime: currentTimeModule.currentTime
    };
}

export default connect(mapStateToMap)(CurrentTimeComponent);