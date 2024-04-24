---
name: Bug Report
description: "Tell us what went wrong and help us improve."
labels: [ "bug" ]
title: "[Bug]: "
body:
  - type: dropdown
    id: community-slack
    attributes:
      label: Is this bug reported and discussed over [Community Slack]((https://open-metadata.org/community)) ?
      multiple: false
      options:
        - "Yes"
        - "No"
      default: 0
    validations:
      required: true
  - type: markdown
    attributes:
      value: |
        # Bug Report
        
        Create a report to help us improve
  - type: checkboxes
    id: checks
    attributes:
      label: Checks
      description: Please check the applicable options.
      options:
        - label: I have checked for existing issues.
          required: true
        - label: This report is about the Openmetadata Helm Chart.
          required: false
        - label: This report is about the Openmetadata Dependencies Helm Chart.
          required: false
  - type: input
    id: affected-module
    attributes:
      label: Affected Module
      description: "Does it impact the UI, backend or Ingestion Framework or Other?"
      placeholder: ""
    validations:
      required: true
  - type: textarea
    id: description
    attributes:
      label: Describe the Bug
      description: A clear and concise description of what the bug is.
      placeholder: ""
    validations:
      required: true
  - type: textarea
    id: steps-to-reproduce
    attributes:
      label: How to Reproduce
      description: Screenshots or steps to reproduce
      placeholder: ""
    validations:
      required: true
  - type: textarea
    id: expected-behavior
    attributes:
      label: Expected Behavior
      description: A clear and concise description of what you expected to happen.
      placeholder: ""
    validations:
      required: true
  - type: input
    id: openmetadata-version
    attributes:
      label: OpenMetadata Version
      description: "Which OpenMetadata Version can this Bug be reproduced ?"
      placeholder: ""
  - type: textarea
    id: additional-context
    attributes:
      label: Additional Context
      description: Add any other context about the problem here.
      placeholder: "Example - slack communication links"
