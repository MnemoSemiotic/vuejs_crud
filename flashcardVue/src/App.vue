<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view/>
    <div class="row">
      <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
        <h1>Http Requests</h1>
        <div class="form-group">
          <label>Question</label>
          <input class="form-control" type="text" v-model="flashcard.question">
        </div>
        <div class="form-group">
          <label>Answer</label>
          <input class="form-control" type="text" v-model="flashcard.answer">
        </div>
        <button class="btn btn-primary" @click="submit">Submit</button>
        <hr>
        <button class="btn btn-primary" @click="fetchData">Get Flashcard</button>
        <ul class="list-group">
          <li class="list-group-item" v-for="f in flashcards">{{ f.question }} : {{ f.answer }} </li>
        </ul>
        </div>
      </div>

  </div>

</template>

<script>
export default {
  data() {
    return {
      flashcard: {
        question: '',
        answer: ''
      },
      flashcards: []
    };
  },
  methods: {
    submit() {
      this.$http.post('http://localhost:8080/flashcards/addflashcard' + '?flashCardQuestion=' + this.flashcard.question + '?&flashCardAnswer=' + this.flashcard.answer )
          .then( response => {
            console.log(response);
          }, error => {
            console.log(error);
          });
    },
    fetchData() {
      this.$http.get('http://localhost:8080/flashcards/', {headers: {'X-Custom': 'HTTP/1.1'}})
          .then(response => {
            return response.json();
          })
          .then(data => {
            const resultArray = [];
            for (let key in data) {
              resultArray.push(data[key]);
            }
            this.flashcards = resultArray;
          });
    }
  }
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
