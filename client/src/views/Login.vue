<template>
  <div class="container mt-4">
    <div class="row">
      <div class="col-sm-4 mx-auto">
        <form @submit.prevent="loginUser" novalidate>

          <div class="form-group">
            <label for="login">Имя</label>
            <input @blur="formLog.login.$touch()"
                   :class="{'is-invalid': formLog.login.$error}"
                   v-model="formLog.login"
                   type="text" class="form-control" id="login"
                   placeholder="Username">
          </div>

          <div class="form-group">
            <label for="password">Пароль</label>
            <input @blur="formLog.password.$touch()"
                   :class="{'is-invalid': formLog.password.$error}"
                   v-model="formLog.password"
                   type="password" class="form-control" id="password"
                   placeholder="Password">
          </div>

          <router-link to="/">
            <button class="btn btn-primary mt-2">Home</button>
          </router-link>
          <button id="login-button" type="submit" class="btn btn-primary mt-2">Вход</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import {required} from 'vuelidate/lib/validators'
import {Login} from '@/utils/Login'

export default {
  name: "Login",
  data() {
    return {
      formLog: {
        login: '',
        password: ''
      }
    }
  },
  methods: {
    loginUser() {
      Login(this.formLog.login, this.formLog.password)
    }
  },
  mounted() {
    if (this.$cookies.get("user_id") != null) {
      window.location = '/'
    }
  },
  validations: {
    formLog: {
      login: {
        required
      }, password: {
        required
      }
    }
  }
}
</script>

<style scoped>

</style>