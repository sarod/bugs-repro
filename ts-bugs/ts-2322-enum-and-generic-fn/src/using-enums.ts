export enum Status {
    SAVING = 'SAVING',
    ERROR = 'ERROR'
}
export type State = SavingState | {
    _tag: Status.ERROR;
    prop2: any;
};

export type SavingState = {
    _tag: Status.SAVING;
    prop1: any;
};


const passThrough = <T>(arg: T): T => arg;


const thisWorks: SavingState = {
    _tag: Status.SAVING,
    prop1: 'whatever'
};

// This fails with
// error TS2322: Type '{ _tag: Status; prop1: string; }' is not assignable to type 'SavingState'.
// Types of property '_tag' are incompatible.
//   Type 'Status' is not assignable to type 'Status.SAVING'
// Related issues
//  *  Type 'Enum' is not assignable to type 'Enum.A' https://github.com/Microsoft/TypeScript/issues/28102
//  * Type inference lost literal type of a enum https://github.com/Microsoft/TypeScript/issues/27704
const thisFailsWhenUsingEnum: SavingState = passThrough({
    _tag: Status.SAVING,
    prop1: 'whatever'
});



// Workaround 1 specify the type in the generic function
const workaround1 = passThrough<SavingState>({
    _tag: Status.SAVING,
    prop1: 'whatever'
});

// Workaround 2 re-specify the type of Status.SAVING
const workaround2 = passThrough({
    _tag: Status.SAVING as Status.SAVING,
    prop1: 'whatever'
});
