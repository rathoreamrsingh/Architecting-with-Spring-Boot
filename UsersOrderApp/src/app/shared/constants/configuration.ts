declare var window: any;

export const commonValues: any = {
    RESPONSE_SUCCESS_STATUS: '0000'
};

export const ENV_PATH: any = {
    DEV_URL: '',
    SIT_URL: '',
    UAT_URL: '',
    LOCALHOST_URL: 'http://192.168.1.6:9090',
    LOCALHOST_SBI_URL: 'http://localhost:3000',
    LOCALHOST_HDFC_URL: 'http://localhost:3001',
}

const SERVICE_URLS_MAP = {
    finduser: '/user-service/user/login',
    orderbyuser: '/order-service/order/getAllOrdersByUserId/',
    saveorder: '/order-service/order/addOrderByUser',
}
export class Config {

    public static getEnvironmentVariable(value) {

        // tslint:disable-next-line:prefer-const
        let environment = window.location.hostname.match('(sit|dev|localhost)')[0];
        environment = environment === 'localhost' ? 'localhost' : environment;
        // let env = window.location.hostname.match('(localhost)');
        console.log(ENV_PATH + SERVICE_URLS_MAP[value]);
        return 'http://127.0.0.1:9090' + SERVICE_URLS_MAP[value];
    }
}