console.log('index.js loaded');


export function bootstrap() {
    console.log('bootsrap called');
    import('./dynamically-imported').then(
        (imported) => {
            console.log('dynamic import fullfilled: ', imported)
            alert('It works')
        },
        (reason) => {
            console.log('dynamic import rejected: ', reason)
            alert('It does not work\n' + reason)
        }
    )
}

bootstrap()