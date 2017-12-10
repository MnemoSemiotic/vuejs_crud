import Vue from 'vue'
import Router from 'vue-router'
import AllCards from '@/components/AllCards'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'AllCards',
      component: AllCards
    }
  ]
})
