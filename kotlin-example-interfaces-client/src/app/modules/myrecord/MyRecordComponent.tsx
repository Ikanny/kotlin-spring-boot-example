/**
 * @author ryuikhan
 * @since 2017. 10. 18.
 */
import * as React from 'react';

const styles = require('./MyRecordComponent.css');

type StateType = {

};

type ActionType = {

};

type PropsType = StateType & ActionType;

export class MyRecordComponent extends React.Component<PropsType> {

    render() {
        return (
            <div>
                <h2>MyRecords</h2>
            </div>
        );
    }
}