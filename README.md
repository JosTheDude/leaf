Velocity Proxy Server Plugin

> In development

# Configuration

`commands.yml`
```yaml
#  __         ______     ______     ______
# /\ \       /\  ___\   /\  __ \   /\  ___\
# \ \ \____  \ \  __\   \ \  __ \  \ \  __\
#  \ \_____\  \ \_____\  \ \_\ \_\  \ \_\
#   \/_____/   \/_____/   \/_/\/_/   \/_/
#
# Author : Smudge

commands:

  reload:
    enabled: true
    name: "leafreload"

    permission: "leaf.reload"
    message: "{message} Reloaded all configs! <3"
```

`messages.yml`
```yaml
#  __         ______     ______     ______
# /\ \       /\  ___\   /\  __ \   /\  ___\
# \ \ \____  \ \  __\   \ \  __ \  \ \  __\
#  \ \_____\  \ \_____\  \ \_\ \_\  \ \_\
#   \/_____/   \/_____/   \/_/\/_/   \/_/
#
# Author : Smudge

# Custom placeholders can be used in any message using curly brackets.
# You can add as many custom placeholders as you like.
#
# Example custom placeholders :
# {message} {error} {vanish_colour} {server} {rank}
placeholders:

  # Simple placeholder.
  message: "&8&l[&f&lServer&8&l]&a"
  error: "&7&l>&7"

  # Conditional placeholder.
  # Conditions are listed in the wiki.
  vanish_colour:
    condition: "MATCH:<vanished>"
    options:
      true: "&#c0fce6"
      false: "&#ffffee"

  server:
    condition: "MATCH:<server>"
    options:
      Default: "<server>"
      TestingServer: '&a&lTest Server'

  rank:
    condition: "PERMISSION:leaf.rank.?"
    options:
      Default: "&f"
      admin: "&a"
```