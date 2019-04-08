import { connect } from 'react-redux';

export type MyCompProps = {
    options: string[];
}

const selectOptions = (state): string[] => ['who cares'];

const mapStateToProps = state => ({
    options: selectOptions(state)
});


export const MyConnectedComp = connect(mapStateToProps)(MyCompProps);


export const MyComp = (props: MyCompProps) => {

}