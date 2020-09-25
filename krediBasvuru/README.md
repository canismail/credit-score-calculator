Calculates credit scores.

## Installation
`git clone https://github.com/canismail/credit-score-calculator.git`

### Backend Service
`cd krediBasvuru/`

`docker build -t java_backend .`

`docker run -it -p 8080:8080 {IMAGE_ID}`

### Frontend Service
`cd src/main/webapp/basvuru`

` docker build -t react_frontend .`

`docker run -it -p 3000:3000 {IMAGE_ID}`

After installation is complited just type `docker ps` 2 running container should be visible.

