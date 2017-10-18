/**
 * @author ryuikhan
 * @since 2017. 10. 18.
 */
import { connect } from 'react-redux';

import { MyRecordComponent as Component } from './MyRecordComponent';

export const MyRecordComponent = connect()(Component);