/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */
import React from 'react';
import styles from './MyFirstComponent.css';

export default class MyFirstComponent extends React.Component {
    render() {
        return (
            <div className={styles.main_panel}>
                <h1>hello world!!!</h1>
            </div>
        );
    }
}