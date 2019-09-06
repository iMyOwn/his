import Vue from 'vue'
import App from './App.vue'
import router from './lib/router'
import store from './lib/store'
import MuseUI from 'muse-ui'
import 'muse-ui/dist/muse-ui.css'
import io from './lib/io'

Vue.use(MuseUI)

Vue.config.productionTip = false
Vue.prototype.$io = io

new Vue({
    render: h => h(App),
    router,
    store
}).$mount('#app')