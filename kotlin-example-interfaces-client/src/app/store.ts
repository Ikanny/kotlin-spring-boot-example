/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
import {createStore, applyMiddleware, Store} from 'redux';
import thunkMiddleware from 'redux-thunk';
import reducers from './reducers';
import {StoreState} from "./type";

const createStoreWithMiddleware = applyMiddleware(thunkMiddleware)(createStore);

export function configureStore( initialState: StoreState ): Store<StoreState> {
    return createStoreWithMiddleware(reducers, initialState);
}