/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import React from 'react';
import { connect } from 'react-redux';
import { getCurrentTime } from './actions';

class CurrentTimeComponent extends React.Component {

    componentDidMount() {
        const { dispatch, currentTime } = this.props;
        dispatch(getCurrentTime());
    }

    render() {
        console.log('render props :', this.props);
        return (
            <div>
                <h2>{this.props.currentTime}</h2>
            </div>
        );
    }
}

function mapStateToMap(state) {
    const currentTimeModule = state.currentTimeModule || {};
    console.log('mapStateToMap state :', state);
    return {
        currentTime: currentTimeModule.currentTime || 123
    };
}

export default connect(mapStateToMap)(CurrentTimeComponent);