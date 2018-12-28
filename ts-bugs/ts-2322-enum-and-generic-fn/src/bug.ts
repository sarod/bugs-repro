export enum Status {
    SAVING = 'SAVING',
    ERROR = 'ERROR'
}
export type State = SavingState | ErrorState;

export type SavingState = {
    _tag: Status.SAVING;
    content: any;
};

export type ErrorState = {
    _tag: Status.ERROR;
    error: Error;
};

const aErrorState: ErrorState = {
    _tag: Status.ERROR,
    error: new Error()
};

const passThrough = <T>(arg: T): T => arg;

// This shoud work as well but raises ts2322
const aErrorStateUsingGenericFn: ErrorState = passThrough({
    _tag: Status.ERROR,
    error: new Error()
});
