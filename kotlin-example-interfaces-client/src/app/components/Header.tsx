/**
 * @author ryuikhan
 * @since 2017. 10. 18.
 */
import * as React from 'react';

const styles = require('./Header.css');

export type HeaderProps = {
    title: string
};

export class Header extends React.Component<HeaderProps> {

    constructor(props) {
        super(props);
    }

    render() {
      return (
          <div className={styles.main_header_container}>
            <h1 className={styles.main_header_title}>{this.props.title}</h1>
          </div>
      )
    }
}