/**
 * @author ryuikhan
 * @since 2017. 10. 18.
 */
import * as React from 'react';

export interface ContainerComponent<A, B, C> extends React.Component<A & B, B> {

}
