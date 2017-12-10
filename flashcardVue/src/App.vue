<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view/>
    <div class="row">
      <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
        <h1>Http Requests</h1>
        <div class="form-group">
          <label>Question</label>
          <input class="form-control" type="text">
        </div>
        <div class="form-group">
          <label>Answer</label>
          <input class="form-control" type="text">
        </div>
        <button class="btn btn-primary">Submit</button>
        </div>
      </div>

  </div>

</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
