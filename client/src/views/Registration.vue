<template>
  <div class="container mt-4">
    <div class="row">
      <div class="col-sm-4 mx-auto">
        <form @submit.prevent="registerUser" novalidate>

          <div class="form-group">
            <label for="login">Имя</label>
            <input @blur="formReg.login.$touch()"
                   :class="{'is-invalid': formReg.login.$error}"
                   v-model="formReg.login"
                   type="text" class="form-control" id="login">
          </div>

          <div class="form-group">
            <label for="password">Пароль</label>
            <input @blur="formReg.password.$touch()"
                   :class="{'is-invalid': formReg.password.$error}"
                   v-model="formReg.password"
                   type="password" class="form-control" id="password">
          </div>

          <div class="form-group">
            <label for="passwordConfirm">Подтвердите пароль</label>
            <input v-model="formReg.passwordConfirm"
                   type="password" class="form-control" id="passwordConfirm">
          </div>
          <router-link to="/">
            <button class="btn btn-primary mt-2">Home</button>
          </router-link>
          <button type="submit" class="btn btn-primary mt-2">Регистрация</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import {required} from 'vuelidate/lib/validators'
import {CreateAccount} from '@/utils/CreateAccount'

export default {
  name: "Registration",
  data() {
    return {
      formReg: {
        login: '',
        password: '',
        passwordConfirm: ''
      }
    }
  },
  methods: {
    registerUser() {
      console.log(this.$route.query)
      CreateAccount(this.formReg.login, this.formReg.password)
    }
  },
  mounted() {
    if (this.$cookies.get("user_id") != null) {
        window.location = '/'
    }
  },
  validations: {
    formReg: {
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