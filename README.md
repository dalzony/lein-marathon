# lein-marathon

Generate json config file for marathon framework from (luminus friendly) config.edn

## Usage

Now, it depends on project.clj of Luminus framework.
Maybe your project.clj looks ...

```clojure
:profiles
  {:uberjar {:omit-source true
             :aot :all
             :uberjar-name "testminsun.jar"
             :source-paths ["env/prod/clj"]
             :resource-paths ["env/prod/resources"]}

   :project/dev  {...
                  :source-paths ["env/dev/clj"]
                  :resource-paths ["env/dev/resources"]
                ...}

```

You can just use `lein marathon` command like this.

```sh
$ lein marathon # default dev
$ lein marathon dev
$ lein marathon prod
```

`dev` is from `resource-paths` of `:project/dev`.
`prod` is from `resource-paths` of `:uberjar`.
So you can change your config path in project.clj.

## Plan

I will add new feature that you can add custom config path to json config file.

## License

Copyright © 2017 Minsun Lee

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
