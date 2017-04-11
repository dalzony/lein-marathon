# lein-marathon

Generate json config file for marathon framework from (luminus friendly) config.edn


## Usage

Add lein-marathon to your plugin list in your project.clj:

```clojure
:plugins [[lein-marathon "0.1.0"]
```

Available commands:

```sh
$ lein marathon # default dev
$ lein marathon dev
$ lein marathon prod
```

It depends on project.clj of Luminus framework.
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

- `dev` is from `resource-paths` of `:project/dev`.
- `prod` is from `resource-paths` of `:uberjar`.

So you can change your config path in project.clj.


### Result

It generated to `.marathon_config_dev` or `.marathon_config_prod`.

from `env/prod/resources/config.edn`

```clojure
{:production true
 :port 3000}
```

to `.marathon_config_prod`

```json
{"PRODUCTION":true,"PORT":3000}
```

You can just copy & paste to your marathon framework configuration on JSON mode.

![marathon-sample](https://cloud.githubusercontent.com/assets/562341/24896456/fda71474-1ecf-11e7-9fb9-eea239889e67.png "marathon sample")


## Plan

I will add new feature that you can add custom config path to json config file.

## Reference

If you want to create environment variables file(eg. ENV_VAR1=1 ...) for Docker containers. Recommend orend's [lein-var-file].

## License

Copyright © 2017 Minsun Lee

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[lein-var-file]: https://github.com/orend/lein-var-file
