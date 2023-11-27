FROM node:17

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install -g nx
RUN npm install

COPY . .

EXPOSE 4200

CMD ["nx", "serve", "restaurant"]
