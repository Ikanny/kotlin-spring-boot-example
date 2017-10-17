/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */
import React from 'react';
import styles from './MyFirstComponent.css';

export default class MyFirstComponent extends React.Component {
    render() {
        return (
            <div>
                <h1 className={styles.main_panel}>test good!!</h1>
            </div>
        );
    }
}