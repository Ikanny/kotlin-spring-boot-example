/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import * as React from 'react';

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