export const Status = {
    SAVING: 'SAVING',
    ERROR: 'ERROR'
}
export type State = SavingState | {
    _tag: typeof Status.ERROR;
    prop2: any;
};

export type SavingState = {
    _tag: typeof Status.SAVING;
    prop1: any;
};

const passThrough = <T>(arg: T): T => arg;

const thisFailsWhenUsingEnum: SavingState = passThrough({
    _tag: Status.SAVING,
    prop1: 'whatever'
});

