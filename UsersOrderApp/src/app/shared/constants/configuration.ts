declare var window: any;

export const commonValues: any = {
    RESPONSE_SUCCESS_STATUS: '0000'
};

export const ENV_PATH: any = {
    DEV_URL: 'http://127.0.0.1:9090',
    SIT_URL: '',
    UAT_URL: '',
    LOCALHOST_URL: 'http://192.168.1.6:9090',
}

const SERVICE_URLS_MAP = {
    finduser: '/user-service/user/login',
    orderbyuser: '/order-service/order/getAllOrdersByUserId/',
    saveorder: '/order-service/order/addOrderByUser',
}

export class Config {

    public static getEnvironmentVariable(value) {
        let environment = window.location.hostname.match('(sit|dev|localhost)')[0];
        environment = environment === 'localhost' ? 'DEV' : environment;
        return ENV_PATH[environment + '_URL'] + SERVICE_URLS_MAP[value];
    }
}
