/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import { createStore, applyMiddleware, compose } from 'redux';
import thunkMiddleware from 'redux-thunk';
import reducers from './reducers';

const createStoreWithMiddleware = applyMiddleware(thunkMiddleware)(createStore);

export default function configureStore( initialState ) {
    // return compose(applyMiddleware(thunkMiddleware))(createStore)(reducers);
    return createStoreWithMiddleware(reducers, initialState);
}